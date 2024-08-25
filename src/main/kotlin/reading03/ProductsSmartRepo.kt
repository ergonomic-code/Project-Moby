package pro.azhidkov.training.project_moby.reading03

import org.springframework.stereotype.Repository
import pro.azhidkov.training.project_moby.reading03.platform.SmartRepository

@Repository
interface ProductsSmartRepo : SmartRepository<Product, Long>
