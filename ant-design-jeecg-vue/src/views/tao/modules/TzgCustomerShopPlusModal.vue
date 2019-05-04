<template>
  <a-modal
    :title="title"
    :width="1200"
    :visible="visible"
    :maskClosable="false"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel">
    <a-spin :spinning="confirmLoading">
      <!-- 主表单区域 -->
      <a-form :form="form">
        <a-row>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="客户ID">
              <a-input placeholder="请输入客户ID" v-decorator="['customerId', validatorRules.customerId ]" disabled/>
            </a-form-item>
          </a-col>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="店铺名称">
              <a-input placeholder="请输入店铺名称" v-decorator="['name', validatorRules.name ]"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="URL">
              <a-input placeholder="请输入URL" v-decorator="['url', {}]"/>
            </a-form-item>
          </a-col>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="平台">
              <a-input placeholder="请输入平台" v-decorator="['platform', {}]"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="掌柜">
              <a-input placeholder="请输入掌柜" v-decorator="['master', {}]"/>
            </a-form-item>
          </a-col>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="旺旺号/京东号">
              <a-input placeholder="请输入旺旺号/京东号等等" v-decorator="['nick', {}]"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="KPI软件">
              <a-input placeholder="请输入绩效软件名称" v-decorator="['dataSoft', {}]"/>
            </a-form-item>
          </a-col>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="KPI账号">
              <a-input placeholder="请输入绩效软件账号" v-decorator="['dataNick', {}]"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="KPI密码">
              <a-input placeholder="请输入绩效软件账号密码" v-decorator="['dataPwd', {}]"/>
            </a-form-item>
          </a-col>
          <a-col :span="12" :gutter="8">
            <a-form-item
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="状态">
              <a-input-number placeholder="请输入状态" style="width:100%" v-decorator="[ 'status', {}]"/>
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>

      <!-- 子表单区域 -->
      <a-tabs v-model="activeKey" @change="handleChangeTabs">
        <a-tab-pane tab="服务账号" :key="refKeys[0]" :forceRender="true">
          <j-editable-table
            :ref="refKeys[0]"
            :loading="tzgShopServiceAccountTable.loading"
            :columns="tzgShopServiceAccountTable.columns"
            :dataSource="tzgShopServiceAccountTable.dataSource"
            :maxHeight="300"
            :rowNumber="true"
            :rowSelection="true"
            :actionButton="true"/>
        </a-tab-pane>
        <a-tab-pane tab="店铺指标" :key="refKeys[1]" :forceRender="true">
          <j-editable-table
            :ref="refKeys[1]"
            :loading="tzgShopKpiTable.loading"
            :columns="tzgShopKpiTable.columns"
            :dataSource="tzgShopKpiTable.dataSource"
            :maxHeight="300"
            :rowNumber="true"
            :rowSelection="true"
            :actionButton="true"/>
        </a-tab-pane>
      </a-tabs>

    </a-spin>
  </a-modal>
</template>

<script>

  import pick from 'lodash.pick'
  import { initDictOptions } from '@/components/dict/JDictSelectUtil'
  import { FormTypes } from '@/utils/JEditableTableUtil'
  import { JEditableTableOneToManyMixin } from '@/mixins/JEditableTableOneToManyMixin'


  export default {
    name: 'TzgCustomerShopPlusModal',
    mixins: [JEditableTableOneToManyMixin],


    data() {
      return {
        // 新增时子表默认添加几行空数据
        addDefaultRowNum: 1,
        validatorRules: {
          customerId: { rules: [{ required: true, message: '请输入客户ID!' }] },
          name: { rules: [{ required: true, message: '请输入店铺名称!' }] }
        },
        refKeys: ['tzgShopServiceAccount', 'tzgShopKpi'],
        activeKey: 'tzgShopServiceAccount',
        statusoptions: [],//状态  0为无效 1为有效
        platformoptions: [],//平台数据
        typeoptions: [],//类型 0主权限账户1一般客服账户
        // 服务账号
        tzgShopServiceAccountTable: {
          loading: false,
          dataSource: [],
          columns: [
            {
              title: '权限账号',
              key: 'account',
              type: FormTypes.input,
              defaultValue: '',
              placeholder: '请输入${title}'
            },
            {
              title: '平台',
              key: 'platform',
              type: FormTypes.select,
              // options: [{"value":"1","title":"哈哈"},{"value":"1","title":"哈哈"}],
              // options: [ // 下拉选项
              //   { title: '天猫', value: '天猫' },
              //   { title: '淘宝', value: '淘宝' },
              //   { title: '京东', value: '京东' }
              // ],
              // options:this.statusoptions,
              options: '',
              placeholder: '请输入${title}'
            },
            {
              title: '数据软件',
              key: 'dataSoft',
              type: FormTypes.input,
              defaultValue: '',
              placeholder: '请输入${title}'
            },
            {
              title: '数据账号',
              key: 'dataAccount',
              type: FormTypes.input,
              defaultValue: '',
              placeholder: '请输入${title}'
            },
            {
              title: '数据账号密码',
              key: 'dataAccountPwd',
              type: FormTypes.input,
              defaultValue: '',
              placeholder: '请输入${title}'
            },
            {
              title: '账号种类',
              key: 'type',
              type: FormTypes.select,
              options: [ // 下拉选项
                { title: '权限账号', value: '0' },
                { title: '客服账号', value: '1' }
              ],
              defaultValue: '1',
              placeholder: '请输入${title}'
            },
            {
              title: '状态',
              key: 'status',
              type: FormTypes.select,
              // options: [ // 下拉选项
              //   { title: '正常', value: '1' },
              //   { title: '无效', value: '0' },
              // ],
              defaultValue: '',
              placeholder: '请输入${title}'
            }
          ]
        },
        // 店铺指标
        tzgShopKpiTable: {
          loading: false,
          dataSource: [],
          columns: [
            {
              title: '指标id',
              key: 'kpiId',
              type: FormTypes.select,
              defaultValue: '',

              placeholder: '请输入${title}'
            },
            {
              title: '指标值',
              key: 'kpiVal',
              type: FormTypes.inputNumber,
              defaultValue: '',
              placeholder: '请输入${title}'
            },
            {
              title: '分值计算公式',
              key: 'scoreFormula',
              type: FormTypes.input,
              defaultValue: '',
              placeholder: '请输入${title}'
            },
            {
              title: '状态',
              key: 'status',
              type: FormTypes.inputNumber,
              defaultValue: '',
              placeholder: '请输入${title}'
            }
          ]
        },
        url: {
          add: '/tao/tzgCustomerShop/add',
          edit: '/tao/tzgCustomerShop/edit',
          type: '/tao/tzgCustomerShop/edit',
          tzgShopServiceAccount: {
            list: '/tao/tzgCustomerShop/queryTzgShopServiceAccountByMainId'
          },
          tzgShopKpi: {
            list: '/tao/tzgCustomerShop/queryTzgShopKpiByMainId'
          }
        }
      }
    },
    created() {
      this.initDictConfig()
    },
    mounted() {
    },
    methods: {
      test() {
        // debugger;
        this.statusoptions = [ // 下拉选项
          { title: '正常', value: '1' },
          { title: '无效', value: '0' }
        ]
      },
      initDictConfig() {
        var that = this
        //初始化字典 - 状态
        initDictOptions('status').then((res) => {
          if (res.success) {
            // debugger
            console.log(that.statusoptions)
            // that.$set(that.tzgShopServiceAccountTable.columns[1], 'options', res.result)
            // that.tzgShopServiceAccountTable= Object.assign({}, that.tzgShopServiceAccountTable)
            // that.$forceUpdate();
            that.statusoptions = res.result
          }
        })
        initDictOptions('platform').then((res) => {
          if (res.success) {
            that.platformoptions = res.result
          }
        })
        initDictOptions('shop_service_account').then((res) => {
          if (res.success) {
            that.typeoptions = res.result
          }
        })
      },
      /** 调用完edit()方法之后会自动调用此方法 */
      editAfter() {
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'customerId', 'name', 'url', 'platform', 'master', 'nick', 'dataSoft', 'dataNick', 'dataPwd', 'status'))
          // 时间格式化
        })
        // 加载子表数据
        if (this.model.id) {
          let params = { id: this.model.id }

          // this.$set(this.tzgShopServiceAccountTable.columns[1], 'options', this.statusoptions)
          this.tzgShopServiceAccountTable.columns[1].options = this.statusoptions
          this.tzgShopServiceAccountTable = Object.assign({}, this.tzgShopServiceAccountTable)
          this.requestSubTableData(this.url.tzgShopServiceAccount.list, params, this.tzgShopServiceAccountTable)
          this.requestSubTableData(this.url.tzgShopKpi.list, params, this.tzgShopKpiTable)
        }
      },

      /** 整理成formData */
      classifyIntoFormData(allValues) {
        let main = Object.assign(this.model, allValues.formValue)
        //时间格式化
        return {
          ...main, // 展开
          tzgShopServiceAccountList: allValues.tablesValue[0].values,
          tzgShopKpiList: allValues.tablesValue[1].values
        }
      }
    }
  }
</script>

<style scoped>
</style>