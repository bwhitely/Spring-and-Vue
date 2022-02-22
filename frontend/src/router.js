import * as VueRouter from 'vue-router'
import {createWebHistory} from "vue-router";
import CustomerList from '@/components/ProductList'
import ProductList from "@/components/ProductList";

export const router = VueRouter.createRouter({
    mode: 'history',
    history: createWebHistory(),
    routes: [
        {
          path: '/',
          alias: '/',
          name: 'home',
            components: {
              CustomerList,
                ProductList
            }
        },
        {
            path: '/customers/',
            alias: '/customers',
            name: 'customers',
            component: () => import('./components/CustomerList')
        },
        {
            path: '/customers/:id',
            name: 'edit-customer',
            component: () => import('./components/EditCustomer')
        },
        {
            path: '/customers/add',
            name: 'add-customer',
            component: () => import('./components/AddCustomer')
        },
        {
            path:'/products/',
            alias: '/products',
            name: 'products',
            component: () => import('./components/ProductList')
        },
        {
            path: '/products/:id',
            name: 'edit-product',
            component: () => import('./components/EditProduct')
        },
        {
            path: '/products/add',
            name: 'add-product',
            component: () => import('./components/AddProduct')
        }
    ]
})