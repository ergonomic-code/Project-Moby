package pro.azhidkov.training.project_moby.reading02

import org.springframework.data.repository.Repository


@org.springframework.stereotype.Repository
// - репозиторий для представления
// Repository - не CrudRepository с методами записи
interface ProductViewsRepo : Repository<ProductView, Long> {

    fun findById(productId: Long): ProductView?

}