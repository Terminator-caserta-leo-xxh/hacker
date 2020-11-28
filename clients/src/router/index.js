const router = {
    routes: [
        {
            path: '*',
            //redirect: '/404'
        },
        //
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
            path: '/',
            name: 'home',
            component: () => import('@/pages/Home')
        },
    ],
    /*scrollBehavior(to, from, savedPosition) {
        return { x: 0, y: 0 }
    }*/
}

export default router
