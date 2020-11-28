const router = {
    routes: [
        {
            path: '/Home',
            component: resolve => require(['../components/Home.vue'], resolve),
            meta: { title: '自述文件' },
            children: [
                {
                    path: '/User',
                    component: resolve => require(['../pages/UserPage.vue'], resolve),
                    meta: { title: 'User' }
                },
                {
                    path: '/Vendor',
                    component: resolve => require(['../pages/VendorPage.vue'], resolve),
                    meta: { title: 'Vendor' }
                },
            ]
        },
        {
            path: '/',
            component: resolve => require(['../pages/Login.vue'], resolve)
        }
    ]
}

export default router
