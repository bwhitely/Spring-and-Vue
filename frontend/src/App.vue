<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <router-link to="/" class="navbar-brand">Basic CRUD App</router-link>
        <div class="collapse navbar-collapse">
          <div class="navbar-nav">
            <router-link to="/customers" class="nav-link">Customer List</router-link>
            <router-link to="/customers/add" class="nav-link">Add New Customer</router-link>
            <router-link to="/products" class="nav-link">Product List</router-link>
            <router-link to="/products/add" class="nav-link">Add New Product</router-link>
          </div>
        </div>
      </div>
    </nav>
    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
