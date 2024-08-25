package pro.azhidkov.training.project_moby.reading02

import org.springframework.data.relational.core.mapping.Table


@Table("producer")
data class ProducerView(
    val id: Long,
    val name: String,
)
