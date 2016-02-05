/* Copyright 2013-2015 www.snakerflow.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dingwang.engine.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dingwang.engine.Action;

/**
 * 节点元素（存在输入输出的变迁）
 * 
 * @author yuqs
 * @since 1.0
 */
public abstract class NodeModel extends BaseModel implements Action {
    /**
     * 
     */
    private static final long     serialVersionUID = -2377317472320109317L;
    private static final Logger   log              = LoggerFactory.getLogger(NodeModel.class);
    /**
     * 输入变迁集合
     */
    private List<TransitionModel> inputs           = new ArrayList<TransitionModel>();
    /**
     * 输出变迁集合
     */
    private List<TransitionModel> outputs          = new ArrayList<TransitionModel>();

    public <T> List<T> getNextModels(Class<T> clazz) {
        List<T> models = new ArrayList<T>();
        for (TransitionModel tm : this.getOutputs()) {
            addNextModels(models, tm, clazz);
        }
        return models;
    }

    protected <T> void addNextModels(List<T> models, TransitionModel tm, Class<T> clazz) {
        if (clazz.isInstance(tm.getTarget())) {
            models.add((T) tm.getTarget());
        } else {
            for (TransitionModel tm2 : tm.getTarget().getOutputs()) {
                addNextModels(models, tm2, clazz);
            }
        }
    }

    public List<TransitionModel> getInputs() {
        return inputs;
    }

    public void setInputs(List<TransitionModel> inputs) {
        this.inputs = inputs;
    }

    public List<TransitionModel> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<TransitionModel> outputs) {
        this.outputs = outputs;
    }

}
