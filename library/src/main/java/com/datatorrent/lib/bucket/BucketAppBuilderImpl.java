/*
 * Copyright (c) 2015 DataTorrent, Inc. ALL Rights Reserved.
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
 */
package com.datatorrent.lib.bucket;

import java.util.HashMap;


public class BucketAppBuilderImpl extends Bucket<HashMap<String,Object>>
{

  public BucketAppBuilderImpl(long bucketKey)
  {
    super(bucketKey);
  }

  /**
   * Finds whether the bucket contains the event.
   *
   * @param event the {@link Bucketable} to search for in the bucket.
   * @return true if bucket has the event; false otherwise.
   */
  public boolean containsEvent(HashMap<String,Object> event)
  {
    if (unwrittenEvents != null && unwrittenEvents.containsKey(event.get(customKey.getEventKey()))) {
      return true;
    }
    return writtenEvents != null && writtenEvents.containsKey(event.get(customKey.getEventKey()));
  }


}
