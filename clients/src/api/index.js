import {get,post,deletes} from "@/api/http";

// ====================== 用户 API
// 注册
export const register = (params) => post(`user/add`,params)
// 登录
export const login = (params) => post(`user/login/status`,params)
// 更新信息
export const updateUserData = (params) => post(`user/update`,params)
// 获取当前用户信息(个人中心）
export const getUserData = () => get(`user/data`)
// 获取当前用户订单
export const getUserOrders = () => get(`user/order`)
// 修改当前订单
export const modifyUserOrders = (params) => post(`user/changeOrder`,params)
// 注销用户
export const deleteThisUser = () => deletes(`user/delete`)


// ====================== 商铺 API
// 注册新的商铺
export const addVendor = (params) => post(`vendorList/add`,params)
// 删除目标商铺
export const delVendor = (id) => deletes(`vendorList/del`,id)
// 更新目标商铺信息
export const updateVendorData = (params) => post(`vendorList/update`,params)
// 获取所有商铺信息
export const getVendorList = () => get('vendorList')
// 获取目标商铺信息
export const getVendorData = (id) => get(`vendorList/detail?vendorID=${id}`)
// 获取指定商铺名的商铺的信息
export const getVendorDataByName = (vendorName) => get(`vendorList/vendorNames/detail?vendorName=${vendorName}`)



// ====================== 管理员 API
// 管理员登录
export const adminLogin = (params) => post(`admin/login/status`,params)
// 获取全部用户
export const getAllUsers = () => get('user')
// 获取目标用户
export const getUser = (id) => get(`user/detail?userID=${id}`)
// 按用户名查询用户
export const getUserByUsername = (username) => get(`user/usernames/detail?username=${username}`)
// 修改目标用户信息
export const modifyUser = (params) => post(`user/update`,params)
// 删除目标用户
export const delUser = (id) => deletes(`user/del`,id)
// 密码修改
export const modifyPwd = (password) => post(`admin/password`,password)


// ====================== 菜单 API
// 获取目标菜品信息
export const getDish = (id) => get(`menu/detail?dishID=${id}`)
// 增加新的菜品信息
export const addDish = (params) => post(`menu/add`,params)
// 更新目标菜品信息
export const updateDish = (params) => post(`menu/update`,params)
// 删除目标菜品信息
export const delDish = (id) => deletes(`menu/del`,id)
// 按名字查询菜品信息
export const getDishByName = (dishName) => get(`menu/dishNames/detail?dishName=${dishName}`)
