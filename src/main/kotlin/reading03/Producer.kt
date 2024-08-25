package pro.azhidkov.training.project_moby.reading03

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import pro.azhidkov.training.project_moby.reading03.platform.Identifiable
import java.time.Instant

data class Producer(
    val name: String,
    val address: String,

    @Id
    override val id: Long = 0,
    @CreatedDate
    val createdAt: Instant = Instant.now()
) : Identifiable<Long>