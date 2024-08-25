package pro.azhidkov.training.project_moby.reading01

import org.springframework.stereotype.Service
import pro.azhidkov.training.project_moby.write_model.ProductsRepo


@Service
class ReadProductService01(
    private val productsRepo: ProductsRepo
) {

    fun getProduct(productId: Long): ProductView {
        val product = productsRepo.findViewById(productId)
            ?: error("Product not found: $productId")

        return product
    }

}