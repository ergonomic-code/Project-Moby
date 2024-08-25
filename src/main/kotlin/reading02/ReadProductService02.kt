package pro.azhidkov.training.project_moby.reading02

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class ReadProductService02(
    private val productViewsRepo: ProductViewsRepo
) {

    fun getProduct(productId: Long): ProductView {
        val product = productViewsRepo.findByIdOrNull(productId)
            ?: error("Product not found: $productId")

        return product
    }

}