package pro.azhidkov.training.project_moby.reading03.platform

import org.springframework.data.jdbc.core.JdbcAggregateOperations
import org.springframework.data.jdbc.core.convert.JdbcConverter
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository
import org.springframework.data.mapping.PersistentEntity


class SmartRepositoryImpl<T : Any, ID>(
    private val jdbcAggregateTemplate: JdbcAggregateOperations,
    private val entity: PersistentEntity<T, *>,
    jdbcConverter: JdbcConverter,
) : SimpleJdbcRepository<T, ID>(jdbcAggregateTemplate, entity, jdbcConverter), SmartRepository<T, ID> {

    override fun findById(id: ID, fetchSpec: FetchSpec<T>): T? {
        val root = jdbcAggregateTemplate.findById(id!!, entity.type)
            ?: return null
        return jdbcAggregateTemplate.hydrate(listOf(root), fetchSpec).single()
    }

}