<template>
  <div>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">Product Name</th>
        <th scope="col">Category</th>
        <th scope="col">Price</th>
        <th scope="col">Actions</th>
      </tr>
      </thead>
      <tbody v-for="(product, index) in products" :key="index">
      <tr>
        <td>{{product.productName}}</td>
        <td>{{product.category}}</td>
        <td>{{product.price}}</td>
        <td><a :href="'/products/' + product.id" class="btn btn-primary">Edit</a> </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ProductDataService from "@/services/ProductDataService";

export default {
  name: "product-list",
  data() {
    return {
      products: []
    }
  },
  methods: {
    retrieveProducts() {
      ProductDataService.getAll()
      .then(res => {
        this.products = res.data
      })
      .catch(e => {
        console.log(e)
      })
    }
  },
  mounted() {
    this.retrieveProducts()
  }
}
</script>

<style scoped>

</style>