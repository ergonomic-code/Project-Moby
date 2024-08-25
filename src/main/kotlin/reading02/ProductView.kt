package pro.azhidkov.training.project_moby.reading02

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Embedded


data class ProductView(
    @Id
    val id: Long,
    val name: String,
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY, prefix = "producer_")
    val producer: ProducerView
)
