package pro.azhidkov.training.project_moby.fixture

import pro.azhidkov.training.project_moby.write_model.Producer


object ProducersObjectMother {

    fun aProducer(
        name: String = faker.company().name(),
        address: String = faker.address().streetAddress(),
    ) = Producer(
        name = name,
        address = address
    )

}