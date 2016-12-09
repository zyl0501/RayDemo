package com.ray.demo.sample.chain;

import java.util.List;

/**
 * 创建时间：2016/12/3
 *
 * @author zyl
 */
interface ILoad {
  boolean support(int type);

  void load();
}

interface ISave{
  boolean support(int type);

  void save();
}

interface IDel{
  boolean support(int type);

  void del();
}

class SaveChain{
  void process(int type){}
}

class LoadChain{
  List<ILoad> loads;

  public LoadChain(List<ILoad> loads) {
    this.loads = loads;
  }

  void process(int type){
    for(ILoad load : loads){
      if(load.support(type)){
        load.load();
      }
    }
  }
}

class Storage{
  List<ILoad> loads;
  List<ISave> saves;
  List<IDel> dels;
}

class Service{
  Storage storage;

  LoadChain loadChain;
  SaveChain saveChain;

  Service(Storage storage){
    this.storage = storage;
    loadChain = new LoadChain(storage.loads);
  }

  void load(int type){
    loadChain.process(type);
  }

  void save(int type){
    saveChain.process(type);
  }
}
