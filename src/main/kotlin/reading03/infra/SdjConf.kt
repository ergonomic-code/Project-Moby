package pro.azhidkov.training.project_moby.reading03.infra

import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import pro.azhidkov.training.project_moby.ProjectMobyApplication
import pro.azhidkov.training.project_moby.reading03.platform.SmartRepositoryImpl


@EnableJdbcRepositories(
    repositoryBaseClass = SmartRepositoryImpl::class,
    basePackageClasses = [ProjectMobyApplication::class]
)
@Configuration
class SdjConf : AbstractJdbcConfiguration()