function createMixIns() {
    function computerQualityMixin(classToExtend) {
        function getQuality() {
            return (this.processorSpeed + this.ram + this.hardDiskSpace) / 3;
        }
        
        function isFast() {
            return this.processorSpeed > (this.ram / 4);
        }
        
        function isRoomy() {
            return this.hardDiskSpace > Math.floor(this.ram * this.processorSpeed);
        }
        
        classToExtend.prototype.getQuality = getQuality;
        classToExtend.prototype.isFast = isFast;
        classToExtend.prototype.isRoomy = isRoomy;
    }
    
    function styleMixin(classToExtend) {
        function isFullSet() {
            return this.manufacturer === this.keyboard.manufacturer && this.manufacturer === this.monitor.manufacturer;
        }

        function isClassy() {
            if(this.battery.expectedLife >= 3){
                if(this.weight < 3){
                    if(this.color === 'Silver' || this.color === 'Black'){
                        return true;
                    }
                }
            }

            return false;
        }

        classToExtend.prototype.isFullSet = isFullSet;
        classToExtend.prototype.isClassy = isClassy;

    }

    return {
        computerQualityMixin,
        styleMixin
    }
}