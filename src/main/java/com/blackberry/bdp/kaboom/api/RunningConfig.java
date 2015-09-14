/*
 * Copyright 2014 BlackBerry, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blackberry.bdp.kaboom.api;

import com.blackberry.bdp.common.versioned.ZkVersioned;
import lombok.Getter;
import lombok.Setter;
import org.apache.curator.framework.CuratorFramework;

public class RunningConfig extends ZkVersioned {
	@Getter @Setter public Boolean allowOffsetOverrides = false;
	@Getter @Setter public Boolean sinkToHighWatermark = false;
	@Getter @Setter public Boolean useTempOpenFileDirectory = true;		
	@Getter @Setter public Boolean useNativeCompression = false;
	@Getter @Setter public long leaderSleepDurationMs = 10 * 60 * 1000;
	@Getter @Setter public short compressionLevel = 6;
	@Getter @Setter public int boomFileBufferSize = 16 * 1024;
	@Getter @Setter public short boomFileReplicas = 3;
	@Getter @Setter public long boomFileBlocksize = 256 * 1024 * 1024;
	@Getter @Setter public String boomFileTmpPrefix = "_tmp_";
	@Getter @Setter public long periodicHdfsFlushInterval = 30 * 1000l;	
	@Getter @Setter public long kaboomServerSleepDurationMs = 10 * 1000;
	@Getter @Setter public long fileCloseGraceTimeAfterExpiredMs = 30 * 1000;
	@Getter @Setter public long forcedZkOffsetTsUpdateMs = 10 * 60 * 1000;
	@Getter @Setter public int maxOpenBoomFilesPerPartition = 5;	
	@Getter @Setter public long workerShiftDurationSeconds = 60 * 60;
	@Getter @Setter public long newLeaderCalmDownDelay = 30 * 1000;
	@Getter @Setter public long assignmentLockTimeout = 3 * 1000;

	/**
	 * Instantiates a default RunningConfig without any ZK interaction
	 */
	public RunningConfig() { }
	
	/**
	 * Instantiates a ZkVersioned RunningConfig from a KaBoom StartupConfig
	 * @param curator
	 * @param zkPathRunningConfig
	 * @throws Exception
	 */
	public RunningConfig(CuratorFramework curator, String zkPathRunningConfig) throws Exception {
		super(curator, zkPathRunningConfig);		
	}
}
