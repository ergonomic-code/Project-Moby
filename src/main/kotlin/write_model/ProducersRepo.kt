package pro.azhidkov.training.project_moby.write_model

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface ProducersRepo : CrudRepository<Producer, Long>