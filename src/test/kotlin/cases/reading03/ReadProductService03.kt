package pro.azhidkov.training.project_moby.cases.reading03

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import pro.azhidkov.training.project_moby.backgrounds.Backgrounds
import pro.azhidkov.training.project_moby.platform.MobyTest
import pro.azhidkov.training.project_moby.reading03.ReadProductService03
import pro.azhidkov.training.project_moby.reading03.platform.resolveOrThrow


@Import(ReadProductService03::class, Backgrounds::class)
@DisplayName("Операция чтения продукта - 03")
class ReadProduct03Test(
    @Autowired private val backgrounds: Backgrounds,
    @Autowired private val readProduct: ReadProductService03
) : MobyTest() {

    @Test
    fun `должна возвращать DTO с заполненым именем производителя`() {
        // Сетап
        val (product, producer) = backgrounds.createAProduct()

        // Действие
        val loadedProduct = readProduct.getProduct(product.id)

        // Проверка
        loadedProduct.id shouldBe product.id
        loadedProduct.name shouldBe product.name
        loadedProduct.producer.id shouldBe producer.id
        loadedProduct.producer.resolveOrThrow().name shouldBe producer.name
    }

}