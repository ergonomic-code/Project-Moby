package pro.azhidkov.training.project_moby.write_model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.core.mapping.AggregateReference
import java.time.Instant

// Write model
data class Product(
    val name: String,
    val description: String,
    val producer: AggregateReference<Producer, Long>, // - ссылка через AggregateReference

    @Id
    val id: Long = 0,
    @CreatedDate
    val createdAt: Instant = Instant.now()
)
