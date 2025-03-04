/*
 * Copyright 2023 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.navercorp.pinpoint.batch;

import com.navercorp.pinpoint.batch.alarm.AlarmSenderConfiguration;
import com.navercorp.pinpoint.batch.configuration.AlarmJobModule;
import com.navercorp.pinpoint.common.server.config.RestTemplateConfiguration;
import com.navercorp.pinpoint.common.server.config.TypeLoaderConfiguration;
import com.navercorp.pinpoint.datasource.MainDataSourceConfiguration;
import com.navercorp.pinpoint.datasource.MetaDataSourceConfiguration;
import com.navercorp.pinpoint.web.UserModule;
import com.navercorp.pinpoint.web.WebHbaseModule;
import com.navercorp.pinpoint.web.webhook.WebhookModule;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@ImportResource({
        "classpath:applicationContext-batch-schedule.xml",

        "classpath:applicationContext-batch-common.xml",
        "classpath:applicationContext-batch-dao-config.xml",
        "classpath:applicationContext-batch-web-component.xml",

        "classpath:job/applicationContext-agentCountJob.xml",
        "classpath:job/applicationContext-flinkCheckJob.xml",
        "classpath:job/applicationContext-cleanupInactiveAgentsJob.xml"
})
@Import({
        TransactionAutoConfiguration.class,
        TypeLoaderConfiguration.class,
        BatchAppPropertySources.class,

        MainDataSourceConfiguration.class,
        MetaDataSourceConfiguration.class,

        AlarmJobModule.class,

        WebhookModule.class,
        WebHbaseModule.class,
        RestTemplateConfiguration.class,
        UserModule.class,
        UriStatAlarmConfiguration.class,
        AlarmSenderConfiguration.class
})
public class BatchModule {
}