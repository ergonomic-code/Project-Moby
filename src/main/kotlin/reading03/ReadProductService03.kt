package pro.azhidkov.training.project_moby.reading03

import org.springframework.stereotype.Service
import pro.azhidkov.training.project_moby.reading03.platform.FetchSpec


@Service
class ReadProductService03(
    private val productsRepo: ProductsSmartRepo
) {

    fun getProduct(productId: Long): Product {
        val product = productsRepo.findById(productId, fetchSpec = FetchSpec(listOf(Product::producer)))
            ?: error("Product not found: $productId")

        return product
    }

}