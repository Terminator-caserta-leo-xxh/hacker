<template>
  <div class="table">
    <div class="container">
      <div class="handle-box">
        <el-button class="handle-del mr10" type="primary" size="mini" @click="delAll">批量删除</el-button>
        <el-input v-model="select_word" class="handle-input mr10" size="mini" placeholder="筛选关键词"></el-input>
        <el-button type="primary" size="mini" @click="centerDialogVisible = true">添加商铺</el-button>
      </div>
      <el-table ref="multipleTable" size="mini" border style="width: 100%" height="550px" :data="data" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column prop="name" label="商铺名" width="120" align="center"></el-table-column>
        <el-table-column prop="password" label="密码" width="120" align="center"></el-table-column>
        <el-table-column prop="email" label="邮件" width="120" align="center"></el-table-column>
        <el-table-column prop="cellphone" label="电话号码" width="120" align="center"></el-table-column>
        <el-table-column prop="openTime" label="营业时间" width="120" align="center"></el-table-column>
        <el-table-column label="是否正在营业" width="50" align="center">
          <template slot-scope="scope">
            <div>{{scope.row.isOpen === 0 ? '否' : '是' }}</div>
          </template>
        </el-table-column>
        <el-table-column label="简介">
          <template slot-scope="scope">
            <p style="height: 100px; overflow: scroll">{{ scope.row.description }}</p>
          </template>
        </el-table-column>
        <el-table-column prop="address" label="地址" width="120" align="center"></el-table-column>
        <el-table-column label="操作" width="150" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
        <el-table-column label="是否通过注册" width="150" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.isValid === 0">
              <el-button size="mini" type="success" round>已通过</el-button>
            </span>
            <span v-else>
              <el-button size="mini" type="primary" round @click="handleRegister(scope.row.id)">通过注册</el-button>
            </span>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
            background
            layout="total, prev, pager, next"
            :current-page="currentPage"
            :page-size="pageSize"
            :total="tableData.length"
            @current-change="handleCurrentChange">
        </el-pagination>
      </div>
    </div>

    <el-dialog title="添加商铺" :visible.sync="centerDialogVisible" width="400px" center>
      <el-form
          class="demo-ruleForm"
          :model="registerForm"
          status-icon
          ref="registerForm"
          label-width="80px"
      >
        <el-form-item prop="name" label="商铺名" size="mini">
          <el-input v-model="registerForm.name" placeholder="商铺名"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码" size="mini">
          <el-input v-model="registerForm.password" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item prop="cellphone" label="电话号码" size="mini">
          <el-input v-model="registerForm.cellphone" placeholder="电话号码"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="邮箱" size="mini">
          <el-input v-model="registerForm.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item prop="beginTime" label="开始营业" size="mini">
          <el-time-select
              v-model="registerForm.beginTime"
              :picker-options="{
                start: '05:00',
                step: '00:30',
                end: '23:30'
              }"
              placeholder="选择开始营业时间">
          </el-time-select>
        </el-form-item>
        <el-form-item prop="endTime" label="结束营业" size="mini">
          <el-time-select
              v-model="registerForm.endTime"
              :picker-options="{
                start: '05:00',
                step: '00:30',
                end: '23:30'
              }"
              placeholder="选择结束营业时间">
          </el-time-select>
        </el-form-item>
        <el-form-item prop="address" label="地址" size="mini">
          <el-input v-model="registerForm.address" placeholder="地址"></el-input>
        </el-form-item>
        <el-form-item prop="description" label="商铺介绍" size="mini">
          <el-input v-model="registerForm.description" type="textarea" placeholder="商铺介绍"></el-input>
        </el-form-item>
      </el-form>
      <span class="dialog-footer" slot="footer">
        <el-button size="mini" @click="centerDialogVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="addNewVendor">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 编辑弹出框 -->
    <el-dialog title="编辑" :visible.sync="editVisible" width="400px">
      <el-form ref="form" :model="form" label-width="60px">
        <el-form-item prop="name" label="商铺名" size="mini">
          <el-input v-model="registerForm.name" placeholder="商铺名"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码" size="mini">
          <el-input v-model="registerForm.password" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item prop="cellphone" label="电话号码" size="mini">
          <el-input v-model="registerForm.cellphone" placeholder="电话号码"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="邮箱" size="mini">
          <el-input v-model="registerForm.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item prop="beginTime" label="开始营业" size="mini">
          <el-time-select
              v-model="registerForm.beginTime"
              :picker-options="{
                start: '05:00',
                step: '00:30',
                end: '23:30'
              }"
              placeholder="选择开始营业时间">
          </el-time-select>
        </el-form-item>
        <el-form-item prop="endTime" label="结束营业" size="mini">
          <el-time-select
              v-model="registerForm.endTime"
              :picker-options="{
                start: '05:00',
                step: '00:30',
                end: '23:30'
              }"
              placeholder="选择结束营业时间">
          </el-time-select>
        </el-form-item>
        <el-form-item prop="address" label="地址" size="mini">
          <el-input v-model="registerForm.address" placeholder="地址"></el-input>
        </el-form-item>
        <el-form-item prop="description" label="商铺介绍" size="mini">
          <el-input v-model="registerForm.description" type="textarea" placeholder="歌手介绍"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button size="mini"  @click="editVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="saveEdit">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 删除提示框 -->
    <el-dialog title="提示" :visible.sync="delVisible" width="300px" center>
      <div class="del-dialog-cnt" align="center">删除不可恢复，是否确定删除？</div>
      <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="delVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="deleteRow">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { mixin } from '@/mixins'
import { addVendor, getVendorList, updateVendorData, delVendor ,passRegister} from '../api/index'

export default {
  name: 'vendor-page',
  mixins: [mixin],
  data () {
    return {
      registerForm: {
        // 添加框信息
        name: '',
        password:'',
        cellphone:'',
        email:'',
        address:'',
        beginTime:'',
        endTime:'',
        description:'',
        isOpen:'',
        isValid:''
      },
      rules: {
        username: [
          { required: true, trigger: 'blur' }
        ],
        password: [
          { required: true, trigger: 'blur' }
        ],
        phoneNum: [
          { message: '请输入电话号码', trigger: 'blur' }
        ],
        email: [
          { message: '请输入邮箱地址', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ]
      },
      tableData: [],
      tempDate: [],
      multipleSelection: [],
      centerDialogVisible: false,
      editVisible: false,
      delVisible: false,
      select_word: '',
      form: {
        // 编辑框信息
        id: '',
        name: '',
        password:'',
        cellphone:'',
        email:'',
        address:'',
        beginTime:'',
        endTime:'',
        description:'',
        isOpen:'',
        isValid: ''
      },
      pageSize: 5, // 页数
      currentPage: 1, // 当前页
      idx: -1
    }
  },
  computed: {
    // 计算当前表格中的数据
    data () {
      return this.tableData.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
    }
  },
  watch: {
    select_word: function () {
      if (this.select_word === '') {
        this.tableData = this.tempDate
      } else {
        this.tableData = []
        for (let item of this.tempDate) {
          if (item.name.includes(this.select_word)) {
            this.tableData.push(item)
          }
        }
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    // 获取当前页
    handleCurrentChange (val) {
      this.currentPage = val
    },
    uploadUrl (id) {
      return `${this.$store.state.HOST}/vendor/avatar/update?id=${id}`
    },
    // 添加商铺
    addNewVendor () {
      let params = new URLSearchParams()
      params.append('name', this.registerForm.name)
      params.append('password', this.registerForm.password)
      params.append('cellphone', this.registerForm.cellphone)
      params.append('email', this.registerForm.email)
      params.append('address',this.registerForm.address)
      params.append('beginTime', this.registerForm.beginTime)
      params.append('endTime',this.registerForm.endTime)
      params.append('description', this.registerForm.description)
      addVendor(params)
          .then(res => {
            if (res.code === 0) {
              this.getData()
              this.registerForm = {}
              this.notify('添加成功', 'success')
            } else {
              this.notify('添加失败', 'error')
            }
          })
          .catch(err => {
            console.log(err)
          })
      this.centerDialogVisible = false
    },
    // 获取全部商铺
    getData () {
      this.tableData = []
      this.tempDate = []
      getVendorList().then(res => {
        this.tableData = res
        this.tempDate = res
        this.currentPage = 1
      })
    },
    // 编辑
    handleEdit (row) {
      this.editVisible = true
      this.idx = row.id
      this.form = {
        id: row.id,
        name: row.name,
        password: row.password,
        cellphone: row.cellphone,
        email: row.email,
        address: row.address,
        beginTime: row.beginTime,
        endTime: row.endTime,
        description: row.description
      }
    },
    // 保存编辑
    saveEdit () {
      let params = new URLSearchParams()
      params.append('name', this.registerForm.name)
      params.append('password', this.registerForm.password)
      params.append('cellphone', this.registerForm.cellphone)
      params.append('email', this.registerForm.email)
      params.append('address',this.registerForm.address)
      params.append('beginTime', this.registerForm.beginTime)
      params.append('endTime',this.registerForm.endTime)
      params.append('description', this.registerForm.description)
      updateVendorData(params)
          .then(res => {
            if (res.code === 0) {
              this.getData()
              this.notify('编辑成功', 'success')
            } else {
              this.notify('编辑失败', 'error')
            }
          })
          .catch(err => {
            console.log(err)
          })
      this.editVisible = false
    },
    // 确定删除
    deleteRow () {
      delVendor(this.idx)
          .then(res => {
            if (res.code === 0) {
              this.getData()
              this.notify('删除成功', 'success')
            } else {
              this.notify('删除失败', 'error')
            }
          })
          .catch(err => {
            console.log(err)
          })
      this.delVisible = false
    },
    //通过注册
    handleRegister (id) {
      let params = new URLSearchParams()
      params.append("id",id)
      passRegister(params).then(res=>{
        if (res.code === 0){
          this.getData()
          this.notify('成功通过','success')
        }
        else {
          this.notify('通过失败','error')
        }
      })
      .catch(err => {
        console.log(err)
      })
    }
  }
}
</script>

<style scoped>
.handle-box {
  margin-bottom: 20px;
}

.handle-input {
  width: 300px;
  display: inline-block;
}

.singer-img {
  width: 100%;
  height: 80px;
  border-radius: 5px;
  margin-bottom: 5px;
  overflow: hidden;
}

.pagination {
  display: flex;
  justify-content: center;
}
</style>
