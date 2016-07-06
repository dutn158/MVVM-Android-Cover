/**
 * Copyright 2016 Erik Jhordan Rey.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package trandu.horical.com.mvvm_android_cover.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class People implements Serializable {

  @SerializedName("gender") public String mGender;

  @SerializedName("name") public Name mName;

  @SerializedName("location") public Location mLocation;

  @SerializedName("email") public String mMail;

  @SerializedName("login") public Login mUserName;

  @SerializedName("phone") public String mPhone;

  @SerializedName("cell") public String mCell;

  @SerializedName("picture") public Picture mPicture;

  public String mFullName;

  public boolean hasEmail() {
    return mMail != null && !mMail.isEmpty();
  }
}
