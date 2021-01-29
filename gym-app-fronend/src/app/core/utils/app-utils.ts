export class AppUtils {

  static loadScript(url:string) {
      let node = document.createElement('script');
      node.type = 'text/javascript';
      node.src = url;
      node.async = true;
      node.charset = 'utf-8';
      node.defer = true;
      document.getElementsByTagName('head')[0].appendChild(node);
    }

    static loadStyles(url:string) {
      // Create link
      let link = document.createElement('link');
      link.href = url;
      link.rel = 'stylesheet';
      link.type = 'text/css';

      let head = document.getElementsByTagName('head')[0];
      let links = head.getElementsByTagName('link');
      let style = head.getElementsByTagName('style')[0];

      // Check if the same style sheet has been loaded already.
      let isLoaded = false;
      for (var i = 0; i < links.length; i++) {
          var node = links[i];
          if (node.href.indexOf(link.href) > -1) {
          isLoaded = true;
          }
      }
      if (isLoaded) return;
      head.insertBefore(link, style);
  }

}
