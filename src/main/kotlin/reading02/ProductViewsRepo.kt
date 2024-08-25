package pro.azhidkov.training.project_moby.reading02

import org.springframework.data.repository.CrudRepository


interface ProductViewsRepo : CrudRepository<ProductView, Long>