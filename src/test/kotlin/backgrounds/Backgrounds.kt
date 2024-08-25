package pro.azhidkov.training.project_moby.backgrounds

import org.springframework.data.jdbc.core.mapping.AggregateReference
import org.springframework.stereotype.Component
import pro.azhidkov.training.project_moby.fixture.ProducersObjectMother.aProducer
import pro.azhidkov.training.project_moby.fixture.ProductsObjectMother
import pro.azhidkov.training.project_moby.write_model.Producer
import pro.azhidkov.training.project_moby.write_model.ProducersRepo
import pro.azhidkov.training.project_moby.write_model.Product
import pro.azhidkov.training.project_moby.write_model.ProductsRepo

data class AProductFixture(
    val product: Product,
    val producer: Producer
)

@Component
class Backgrounds(
    private val producersRepo: ProducersRepo,
    private val productsRepo: ProductsRepo
) {

    fun createAProduct(): AProductFixture {
        val producer = producersRepo.save(aProducer())
        val product = productsRepo.save(ProductsObjectMother.aProduct(producer = AggregateReference.to(producer.id)))
        return AProductFixture(product, producer)
    }

}