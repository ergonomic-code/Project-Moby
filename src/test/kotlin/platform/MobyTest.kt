package pro.azhidkov.training.project_moby.platform

import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.test.context.ActiveProfiles
import pro.azhidkov.training.project_moby.fixture.resetFaker


@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJdbcTest
abstract class MobyTest {

    @BeforeEach
    fun resetFakerInstance() {
        resetFaker()
    }

}