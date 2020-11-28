const router = {
    routes: [
        {
            path: '*',
            redirect: '/404'
        },
        {
            path: '/404',
            component: () => import('@/pages/404.vue')
        },

    ],
    scrollBehavior(to, from, savedPosition) {
        return { x: 0, y: 0 }
    }
}

export default router
