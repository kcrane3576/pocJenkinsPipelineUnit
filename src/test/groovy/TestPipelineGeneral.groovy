import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test


class TestPipelineGeneral extends BasePipelineTest {

    @Override
    @Before
    void setUp() throws Exception {
        helper.baseScriptRoot = 'pocJenkinsPipelineUnit'
        helper.scriptRoots += 'src/main/groovy'
        super.setUp()
    }

    @Test
    void temp(){
        println("temp")
        def script = loadScript("pipelineGeneral.groovy")
    }
}