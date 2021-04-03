Vue.http.options.emulateJSON = true;
Vue.http.options.emulateHTTP = true;
var vm = new Vue({
    el: '#vm',
    data: {tableData: [], currentPage: 1, total: 10, listLoading: false, username: null},
    mounted: function () {
        this.findAll();
    },
    methods: {
        findAll: function (currentPage) {
            this.listLoading = true;
            if (!isNaN(currentPage)) {
                this.currentPage = currentPage;
            }
            var params_ = {pageNum: this.currentPage, pageSize: 10};
            if (this.username && this.username.trim() != "") {
                params_['username'] = this.username;
            }
            this.$http.get("/user/getTableData", {params: params_}).then(function (response) {
                console.log(response.data);
                this.total = response.data.count;
                this.tableData = [];
                for (var i in response.data.list) {
                    this.$set(this.tableData, i, response.data.list[i]);
                }

            }).catch(function (response) {
                console.error(response);
            });
            this.listLoading = false;
        }, formatDate: function getNowFormatDate(time) {
            var date = new Date(time);
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate + " " + date.getHours() + seperator2 + date.getMinutes() + seperator2 + date.getSeconds();
            return currentdate;
        }, formatCreateDate: function (row, column) {
            if (row.createTime != null) {
                return this.formatDate(row.createTime);
            } else {
                return '';
            }
        }, formatSex: function (row, column) {
            if (row.sex != null) {
                return row.sex == 1 ? '男' : '女';
            }
        }, changeUsername: function () {
            this.findAll(1);
        }
    }
});