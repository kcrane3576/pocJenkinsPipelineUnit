class TestPipelineGeneral extends BasePipelineTest {

    @Override
    @Before
    void setUp() throws Exception {
        helper.baseScriptRoot = 'pocJenkinsPipelineUnit'
        helper.roots += 'src/main/groovy'
        helper.extension = 'groovy'
        super.setUp()
    }

}