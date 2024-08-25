package pro.azhidkov.training.project_moby.cases.reading01

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import pro.azhidkov.training.project_moby.backgrounds.Backgrounds
import pro.azhidkov.training.project_moby.platform.MobyTest
import pro.azhidkov.training.project_moby.reading01.ReadProductService01


@Import(ReadProductService01::class, Backgrounds::class)
@DisplayName("Операция чтения продукта - 01")
class ReadProduct01(
    @Autowired private val backgrounds: Backgrounds,
    @Autowired private val readProduct: ReadProductService01
) : MobyTest() {

    @Test
    fun `должна возвращать DTO с заполненым именем производителя`() {
        // Сетап
        val (product, producer) = backgrounds.createAProduct()

        // Действие
        val productView = readProduct.getProduct(product.id)

        // Проверка
        productView.id shouldBe product.id
        productView.name shouldBe product.name
        productView.producer.id shouldBe producer.id
        productView.producer.name shouldBe producer.name
    }

}