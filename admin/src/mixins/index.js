export const mixin = {
    methods: {
        // 提示信息
        notify (title, type) {
            this.$notify({
                title: title,
                type: type
            })
        },
        getUrl (url) {
            return `${this.$store.state.HOST}/${url}`
        },
        // 获取要删除列表的id
        handleDelete (id) {
            this.idx = id
            this.delVisible = true
        },
        // 获取批量要删除的列表
        handleSelectionChange (val) {
            this.multipleSelection = val
        },
        // 批量删除
        delAll () {
            for (let item of this.multipleSelection) {
                this.handleDelete(item.id)
                this.deleteRow(item.id)
            }
            this.multipleSelection = []
        },
    }
}
