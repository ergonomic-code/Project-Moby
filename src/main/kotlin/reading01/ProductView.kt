package pro.azhidkov.training.project_moby.reading01

import org.springframework.data.relational.core.mapping.Embedded


data class ProductView( // 04 - Read model
    val id: Long,
    val name: String,
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY, prefix = "producer_")
    val producer: ProducerView // 05 - embedded producer
)
