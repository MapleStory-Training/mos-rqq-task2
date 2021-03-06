/*
 * This file is part of MOS
 * <p>
 * Copyright (c) 2021 by cooder.org
 * <p>
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package org.cooder.mos;

import org.cooder.mos.device.FileDisk;
import org.cooder.mos.shell.Shell;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        FileDisk disk = new FileDisk("mos-disk");
        MosSystem.fileSystem().bootstrap(disk);

        try {
            Shell shell = new Shell("/");
            shell.loop();
        } finally {
            MosSystem.fileSystem().shutdown();
        }
    }
}
