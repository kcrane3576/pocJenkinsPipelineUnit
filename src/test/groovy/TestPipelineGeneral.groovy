import com.lesfurets.jenkins.unit.BasePipelineTest
import com.lesfurets.jenkins.unit.global.lib.GitSource
import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import org.junit.Before
import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Test
import org.junit.rules.TemporaryFolder

class TestPipelineGeneral extends BasePipelineTest {

//    @ClassRule
//    public static TemporaryFolder folder = new TemporaryFolder()
//
//    static File temp
//
//    @BeforeClass
//    static void init(){
//        temp = folder.newFolder("libs")
//    }

    @Override
    @Before
    void setUp() throws Exception {
        super.setUp()
        helper.baseScriptRoot = 'pocJenkinsPipelineUnit'
        helper.scriptRoots += 'src/main/groovy'
//        helper.registerSharedLibrary(library("jenkinsfiles")
//                .defaultVersion('master')
//                .allowOverride(true)
//                .targetPath(temp.path)
//                .retriever(GitSource.gitSource("https://github.com/kcrane3576/pocJenkinsPipelineUnit.git"))
//                .build())
    }

    @Test
    void temp(){
        println("temp")
//        def script = loadScript("pipelineGeneral.groovy")
//        script.checkout("ip-service1")

        def script = loadScript("src/main/groovy/configBuilder.groovy")
        script.getJenkinsfileConfig("ip-service1")

        printCallStack()

    }
}