package org.epam.core.utils;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static org.apache.commons.io.FileUtils.readFileToString;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {

    @SneakyThrows
    public static File getResource(String resourcePath) {
        final URL resource = Thread.currentThread().getContextClassLoader()
                .getResource(resourcePath);
        checkArgument(nonNull(resource), format("file %s should exist!", resourcePath));
        return new File(resource.toURI());
    }

    @SneakyThrows
    public static String readFromFileNamed(final String directory, final String fileName) {
        final var file = new File(getResource(directory), fileName);
        checkArgument(file.exists(), format("File %s not found!", file));
        return readFileToString(file, Charset.defaultCharset());
    }
}
