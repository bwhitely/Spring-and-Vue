<template>
<div>
  <div v-if="!submitted">
    <div class="mb-3">
      <label for="productName" class="form-label">Product Name</label>
      <input type="text" class="form-control" id="productName" required name="productName" v-model="product.productName">
    </div>
    <div class="mb-3">
      <label for="category" class="form-label">Category</label>
      <input type="text" class="form-control" id="category" required name="category" v-model="product.category">
    </div>
    <div class="mb-3">
      <label for="price" class="form-label">Price</label>
      <input type="text" class="form-control" id="price" required name="price" v-model="product.price">
    </div>
    <div class="mb-3">
      <button @click="saveProduct" class="btn btn-primary">Submit</button>
    </div>
  </div>
  <div v-else>
    <div class="alert alert-success" role="alert">
      Saved product successfully.
    </div>
    <button @click="newProduct" class="btn btn-primary">Add new product</button>
  </div>
</div>
</template>

<script>
import ProductDataService from "@/services/ProductDataService";

export default {
  name: "add-product",
  data() {
    return {
      product: {
        id: null,
        productName: "",
        category: "",
        price: 0.0
      },
      submitted: false
    }
  },
  methods: {
    saveProduct(){
      let data = {
        productName: this.product.productName,
        category: this.product.category,
        price: this.product.price
      }
      ProductDataService.create(data)
      .then(res => {
        this.product.id = res.data.id;
        this.submitted = true;
      })
      .catch(e => {
        console.log(e)
      })
    },
    newProduct() {
      this.submitted = false
      this.product = {}
    }
  }
}
</script>

<style scoped>

</style>