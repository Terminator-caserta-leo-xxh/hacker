const router = {
    routes: [

        {
            path: '/Home',
            component: resolve => require(['../pages/Home'], resolve)},

        {
            path: '*',
                    redirect: '/404'
        },
        {
            path: '/404',
            component: () => import('@/pages/404.vue')
        },
        {
            path: '/login-in',
            name: 'login-in',
            component: () => import('@/pages/LoginIn')
        },
        {
            path: '/sign-up',
            name: 'sign-up',
            component: () => import('@/pages/SignUp')
        },
        {
            path: '/setting',
            name: 'setting',
            component: () => import('@/pages/Setting')
        },
    {
    path: '/',
        name: 'log-in',
        component: () => import('@/pages/LoginIn')
    },
    ]

    // scrollBehavior(to, from, savedPosition) {
    //     return { x: 0, y: 0 }
    // }
}

export default router
