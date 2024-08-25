@file:Suppress("UNCHECKED_CAST")

package pro.azhidkov.training.project_moby.reading03.platform

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonUnwrapped
import org.springframework.data.jdbc.core.mapping.AggregateReference


data class AggregateReferenceTarget<T : Identifiable<ID>, ID : Any>(
    @JsonUnwrapped val entity: T
) : AggregateReference<T, ID> {

    @JsonIgnore
    override fun getId(): ID = entity.id

}

fun <R : AggregateReference<T, ID>?, ID : Any, T : Identifiable<ID>> R.resolveOrThrow(): T =
    (this as? AggregateReferenceTarget<T, ID>)?.entity
        ?: error("$this is not instance of AggregateReferenceTarget")