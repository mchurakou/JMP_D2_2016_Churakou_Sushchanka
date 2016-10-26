package com.company.sushchanka.PowerMock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.*;


/**
 * Created by alt-hanny on 26.10.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RandomTextGenerator.class, Examples.class, Example.class})
public class ExamplesTest {
    Examples examples = new Examples();

    @Mock
    Map<Long, String> exampleMapMock;

    @InjectMocks
    Examples examps = new Examples();

    @Rule
    TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testRandomString_mockStaticFinalMethod() throws Exception {
        String expectedName = "qqqqqqqq";
        mockStatic(RandomTextGenerator.class);
        when(RandomTextGenerator.randomString(8)).thenReturn(expectedName);
        Example result = examples.getExample();
        assertEquals(expectedName, result.getName());
    }

    @Test
    public void testRandomString_mockConstructor() throws Exception {
        String expectedName = "qqqqqqqq";
        Example example = mock(Example.class);
        when(example.getName()).thenReturn(expectedName);
        whenNew(Example.class).withAnyArguments().thenReturn(example);
        Example result = examples.getExample();
        assertEquals(expectedName, result.getName());
    }

    @Test
    public void testGetMassage_mockStaticMethod() throws Exception {
        String expectedMessage = "Hello";
        spy(Examples.class);
        doReturn(expectedMessage).when(Examples.class, "getMessage");
        String retrived = WhiteboxImpl.invokeMethod(Examples.class, "getMessage");
        assertEquals(expectedMessage, retrived);
    }

    @Test
    public void testGetExample_mockFinalMethod() throws Exception {
        Examples examples = mock(Examples.class);
        final Example result = new Example(5);
        when(examples.getExample()).thenReturn(result);
        assertEquals(examples.getExample(),result);
    }

    @Test
    public void testInjectMockAnnotation() throws Exception {
        when(exampleMapMock.get("aaa")).thenReturn("bbb");
        assertEquals("bbb", examps.getName("aaa"));
    }

    @Test
    public void testFileSystem() throws Exception {
        Examples examples = mock(Examples.class);
        File createdFile = folder.newFile("qqq.cvs");
        when(examples.createFile()).thenReturn(createdFile.exists());
        assertEquals(createdFile.exists(), examples.createFile());
    }

    @Test
    public void testDBConnection() throws SQLException {
        Examples examples = mock(Examples.class);
        when(examples.getDBConnection()).thenReturn("No connection");
        assertEquals(examples.getDBConnection(), "No connection");
    }
}