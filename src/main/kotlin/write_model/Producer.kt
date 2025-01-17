package pro.azhidkov.training.project_moby.write_model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import java.time.Instant

data class Producer(
    val name: String,
    val address: String,

    @Id
    val id: Long = 0,
    @CreatedDate
    val createdAt: Instant = Instant.now()
)
