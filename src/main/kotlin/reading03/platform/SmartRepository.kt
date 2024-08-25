package pro.azhidkov.training.project_moby.reading03.platform

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.NoRepositoryBean


@NoRepositoryBean
interface SmartRepository<T, ID> : CrudRepository<T, ID> {

    fun findById(id: ID, fetchSpec: FetchSpec<T>): T?

}