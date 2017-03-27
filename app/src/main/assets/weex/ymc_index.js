// { "framework": "Vue" }
/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = []

	/* styles */
	__vue_styles__.push(__webpack_require__(1)
	)

	/* script */
	__vue_exports__ = __webpack_require__(2)

	/* template */
	var __vue_template__ = __webpack_require__(3)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "/Users/zhangshixin/Documents/weex/weexdemo/ymc_index.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__._scopeId = "data-v-4828ceac"
	__vue_options__.style = __vue_options__.style || {}
	__vue_styles__.forEach(function (module) {
	  for (var name in module) {
	    __vue_options__.style[name] = module[name]
	  }
	})
	if (typeof __register_static_styles__ === "function") {
	  __register_static_styles__(__vue_options__._scopeId, __vue_styles__)
	}

	module.exports = __vue_exports__
	module.exports.el = 'true'
	new Vue(module.exports)


/***/ },
/* 1 */
/***/ function(module, exports) {

	module.exports = {
	  "wrapper": {
	    "justifyContent": "center",
	    "flexDirection": "column"
	  },
	  "slider": {
	    "minWidth": 750,
	    "height": 400,
	    "borderWidth": 2,
	    "borderStyle": "solid",
	    "borderColor": "#418883"
	  },
	  "frame": {
	    "minWidth": 750,
	    "height": 400
	  },
	  "image": {
	    "minWidth": 750,
	    "height": 400
	  },
	  "bannerTitle": {
	    "position": "absolute",
	    "top": 20,
	    "left": 20,
	    "paddingLeft": 20,
	    "width": 600,
	    "color": "#FFFFFF",
	    "fontSize": 20,
	    "lineHeight": 60,
	    "backgroundColor": "rgba(0,0,0,0.3)"
	  },
	  "group": {
	    "flexDirection": "row",
	    "justifyContent": "center",
	    "marginBottom": 40,
	    "padding": 20
	  },
	  "title": {
	    "fontSize": 35,
	    "color": "#888888"
	  },
	  "count": {
	    "fontSize": 15,
	    "fontWeight": "bold",
	    "marginLeft": 12,
	    "color": "#41B883"
	  },
	  "indicator": {
	    "itemColor": "green",
	    "itemSelectedColor": "red",
	    "itemSize": 50,
	    "position": "absolute",
	    "left": 300,
	    "top": 600,
	    "backgroundColor": "#3c3c3c",
	    "width": 500
	  }
	}

/***/ },
/* 2 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	var stream = weex.requireModule('stream');

	exports.default = {
		data: function data() {
			return {
				indexData: 'unknown',
				defaultCityId: '7d04e3a1-ee87-431c-9aa7-ac245014c51a',
				// imageURLPre: 'http://produce.oss-cn-hangzhou.aliyuncs.com/ops',
				bannerList: []
			};
		},

		methods: {
			getIndexData: function getIndexData(cityId, callback) {
				return stream.fetch({
					method: 'GET',
					type: 'json',
					url: 'http://ymcapi.yaomaiche.com/ymc/index/?cityId=' + cityId
				}, callback);
			},
			bannerClick: function bannerClick(event) {}
		},
		created: function created() {
			var _this = this;

			this.getIndexData(this.defaultCityId, function (res) {
				_this.indexData = res.ok ? res.data.data.advertiseList : '(analysis data error)';
				if (res.ok) {
					_this.indexData = res.data.data;
					_this.bannerList = _this.indexData.bannerView.bannerList;
					console.log(_this.bannerList);
				}
			});
		}
	};
	module.exports = exports['default'];

/***/ },
/* 3 */
/***/ function(module, exports) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
	  return _c('scroller', [_c('div', {
	    staticClass: ["wrapper"]
	  }, [_c('slider', {
	    staticClass: ["slider"],
	    attrs: {
	      "interval": "3000",
	      "autoPlay": "true"
	    },
	    on: {
	      "onclick": _vm.bannerClick
	    }
	  }, [_vm._l((_vm.bannerList), function(banner) {
	    return _c('div', {
	      staticClass: ["frame"]
	    }, [_c('image', {
	      staticClass: ["image"],
	      attrs: {
	        "resize": "cover",
	        "src": banner.picUrl
	      }
	    }), _c('text', {
	      staticClass: ["bannerTitle"]
	    }, [_vm._v(_vm._s(banner.picUrl))])])
	  }), _c('indicator', {
	    staticClass: ["indicator"]
	  })], 2), _c('div', {
	    staticClass: ["group"]
	  }, [_c('text', {
	    staticClass: ["title"]
	  }, [_vm._v("YMC index:")]), _c('text', {
	    staticClass: ["count"]
	  }, [_vm._v(_vm._s(_vm.indexData))])])])])
	},staticRenderFns: []}
	module.exports.render._withStripped = true

/***/ }
/******/ ]);