package pro.azhidkov.training.project_moby.cases.write_model

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jdbc.core.mapping.AggregateReference
import org.springframework.data.repository.findByIdOrNull
import pro.azhidkov.training.project_moby.fixture.ProducersObjectMother.aProducer
import pro.azhidkov.training.project_moby.fixture.ProductsObjectMother.aProduct
import pro.azhidkov.training.project_moby.platform.MobyTest
import pro.azhidkov.training.project_moby.write_model.ProducersRepo
import pro.azhidkov.training.project_moby.write_model.ProductsRepo


@DisplayName("Репозиторий продуктов")
class ProductsSmartRepoTest(
    @Autowired private val repo: ProductsRepo,
    @Autowired private val producersRepo: ProducersRepo
) : MobyTest() {

    @Test
    fun `должен сохранять агрегаты`() {
        // Сетап
        val producer = producersRepo.save(aProducer())
        val product = aProduct(producer = AggregateReference.to(producer.id))

        // Действие
        val id = repo.save(product).id

        // Проверка
        id shouldNotBe 0
        val loadedProduct = repo.findByIdOrNull(id)
        loadedProduct shouldNotBe null
        loadedProduct!!.name shouldBe product.name
        loadedProduct.producer shouldBe AggregateReference.to(producer.id)
    }

}