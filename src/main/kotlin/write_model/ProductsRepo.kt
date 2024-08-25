package pro.azhidkov.training.project_moby.write_model

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pro.azhidkov.training.project_moby.reading01.ProductView

@Repository
interface ProductsRepo : CrudRepository<Product, Long> {

    @Query(
        """SELECT 
                  pt.id, pt.name, pr.id AS producer_id, pr.name AS producer_name
              FROM product pt 
                  JOIN producer pr ON pt.producer = pr.id
              WHERE 
                  pt.id = :productId"""
    )
    fun findViewById(productId: Long): ProductView?

}
