/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the “License”). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.master.file.options;

import alluxio.proto.journal.File;
import alluxio.thrift.MountTOptions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link MountOptions}.
 */
public class MountOptionsTest {
  /**
   * Tests the {@link MountOptions#defaults()} method.
   */
  @Test
  public void defaultsTest() {
    MountOptions options = MountOptions.defaults();
    Assert.assertFalse(options.isReadOnly());
  }

  /**
   * Tests creating a {@link MountOptions} from a thrift object.
   */
  @Test
  public void FromThriftTest() {
    // Null thrift options
    MountTOptions thriftOptions = null;
    MountOptions options = new MountOptions(thriftOptions);
    Assert.assertFalse(options.isReadOnly());

    // Default thrift options
    thriftOptions = new MountTOptions();
    options = new MountOptions(thriftOptions);
    Assert.assertFalse(options.isReadOnly());

    // Set thrift options
    thriftOptions = new MountTOptions();
    thriftOptions.setReadOnly(true);
    options = new MountOptions(thriftOptions);
    Assert.assertTrue(options.isReadOnly());
  }

  /**
   * Tests creating a {@link MountOptions} from a proto object.
   */
  @Test
  public void FromProtoTest() {
    // Null proto options
    File.AddMountPointEntry protoOptions = null;
    MountOptions options = new MountOptions(protoOptions);
    Assert.assertFalse(options.isReadOnly());

    // Default proto options
    protoOptions = File.AddMountPointEntry.newBuilder().build();
    options = new MountOptions(protoOptions);
    Assert.assertFalse(options.isReadOnly());

    // Set proto options
    protoOptions = File.AddMountPointEntry.newBuilder().setReadOnly(true).build();
    options = new MountOptions(protoOptions);
    Assert.assertTrue(options.isReadOnly());
  }

  /**
   * Tests getting and setting fields.
   */
  @Test
  public void fieldsTest() {
    MountOptions options = MountOptions.defaults().setReadOnly(true);
    Assert.assertTrue(options.isReadOnly());

    options = MountOptions.defaults().setReadOnly(false);
    Assert.assertFalse(options.isReadOnly());
  }
}
